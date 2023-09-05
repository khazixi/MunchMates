import { createEvent, createInvite, getProfile } from "@/db/queries";
import { DrizzleError } from "drizzle-orm";
import e from "express";
import z from "zod";

const hallSchema = z.enum([
  'Berkshire',
  'Hampsire',
  'Franklin',
  'Wocester',
])

const eventSchema = z.object({
  organizer: z.string(),
  hall: hallSchema,
  timestamp: z.string().datetime(),
  duration: z.string().regex(/\w{2}:\w{2}/)
})

const inviteSchema = z.object({
  event: z.number(),
  from: z.number(),
  to: z.number(),
  status: z.enum(['accepted', 'pending', 'rejected'])
})

const apiRouter = e.Router()

apiRouter.get('/api/profile/:id', (req, res) => {
  const user_id = req.params.id
  const result = z.coerce.number().safeParse(user_id)
  if (!result.success) {
    return res.sendStatus(400).send('Must send a query parameter that is a number')
  }
  const id = result.data
  const data = getProfile(id)
  res.json(data)
})

apiRouter.post('/api/event', async (req, res) => {
  const events = eventSchema.safeParse(req.body)
  if (!events.success) {
    return res.status(400).send(events.error)
  }
  const { data: event } = events
  try {
    const result = await createEvent(event)
    const data = result[0]
    if (!data) {
      return res.send('Failed to Insert into database').status(500)
    }
    res.status(200).json(result)
  } catch (e) {
    if (e instanceof DrizzleError) {
      res.status(500).send(e.message)
    } else {
      res.status(500).send('Unknown Error')
    }
  }
})

apiRouter.post('/api/invite', async (req, res) => {
  const result = inviteSchema.safeParse(req.body)
  if (!result.success) {
    return res.status(400).send(result.error)
  }
  const { data: invite } = result
  try {
    await createInvite(invite)
    res.sendStatus(201)
  } catch (e) {
    res.status(500).send('Unknown Error')
  }
})

export default apiRouter

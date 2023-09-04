import e from "express";


export const apiRouter = e.Router()

apiRouter.get('/api/profile', (req, res) => {
  res.send('Profile Route')
})

apiRouter.get('/api/hall', (req, res) => {
  res.send('Dining Hall Route')
})

apiRouter.get('/api/invite', (req, res) => {
  res.send('This is wheree you can invite friends')
})

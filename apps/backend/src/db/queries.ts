// NOTE: We can put all of our queries here
// NOTE: I don't care if you use drizzle or write it raw, just add types so we know what we're using

import { eq, and } from "drizzle-orm";
import { db } from "./db";
import { event, invite, sqlEvent, sqlInvite, users } from './schema'

export async function getParticipatingUsers(event_id: number) {
  return await db
    .select({
      name: users.name,
      gender: users.gender
    })
    .from(invite)
    .where(
      eq(invite.event, event_id),
    )
    .leftJoin(
      users,
      and(
        eq(
          invite.to,
          users.user_id
        ),
        eq(
          invite.status,
          'accepted'
        )
      )
    )
}

export async function getInvites(user_id: number) {
  return await db
    .select()
    .from(invite)
    .where(
      and(
        eq(invite.to, user_id),
        eq(invite.status, 'pending')
      )
    )
}

export async function updateInvites(user_id: number, event_id: number, accepted: boolean) {
  return await db
    .update(invite)
    .set({
      status: (accepted) ? 'accepted' : 'rejected'
    })
    .where(
      and(
        eq(invite.to, user_id),
        eq(invite.event, event_id)
      )
    )
}

export async function createEvent(arg: sqlEvent) {
  return await db
    .insert(event)
    .values(arg)
    .returning({ id: event.event_id })
}

export async function getProfile(user_id: number) {
  return await db
    .select()
    .from(users)
    .where(
      eq(
        users.user_id,
        user_id
      )
    )
}

export async function createInvite(arg: sqlInvite) {
  return db
    .insert(invite)
    .values(arg)
}

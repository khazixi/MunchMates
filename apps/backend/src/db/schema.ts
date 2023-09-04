// NOTE: We can make typescript schemas here and change them for migrations

import { sqliteTable, text, integer } from "drizzle-orm/sqlite-core";

export const users = sqliteTable('users', {
  user_id: integer('user_id').primaryKey(),
  name: text('name'),
  gender: text('geneder', {
    enum: ['male', 'female', 'non-binary', 'other']
  })
})

export const event = sqliteTable('event', {
  event_id: integer('event_id').primaryKey(),
  organizer: text('organizer')
    .references(() => users.name),
  hall: text('hall', {
    enum: ['Wocester', 'Berkshire', 'Hampsire', 'Franklin']
  }),
  timestamp: text('timestamp'), // NOTE: Use time function to get around lack of type
  duration: text('duration'),
  details: text('details')
})

export const invite = sqliteTable('invite', {
  from: integer('from').references(() => users.user_id),
  to: integer('to').references(() => users.user_id),
  event: integer('event').references(() => event.event_id),
  status: text('status', {
    enum: ['accepted', 'pending', 'rejected']
  }).notNull()
})

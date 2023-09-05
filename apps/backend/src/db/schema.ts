// NOTE: We can make typescript schemas here and change them for migrations

import { InferInsertModel } from "drizzle-orm";
import { sqliteTable, text, integer } from "drizzle-orm/sqlite-core";

export const users = sqliteTable('users', {
  user_id: integer('user_id').primaryKey(),
  name: text('name').notNull(),
  gender: text('geneder', {
    enum: ['male', 'female', 'non-binary', 'other']
  }).notNull()
})

export const event = sqliteTable('event', {
  event_id: integer('event_id').primaryKey(),
  organizer: text('organizer')
    .notNull()
    .references(() => users.name),
  hall: text('hall', {
    enum: ['Wocester', 'Berkshire', 'Hampsire', 'Franklin']
  }).notNull(),
  timestamp: text('timestamp').notNull(), // NOTE: Use time function to get around lack of type
  duration: text('duration').notNull(),
  details: text('details')
})

export const invite = sqliteTable('invite', {
  from: integer('from').notNull().references(() => users.user_id),
  to: integer('to').notNull().references(() => users.user_id),
  event: integer('event').notNull().references(() => event.event_id),
  status: text('status', {
    enum: ['accepted', 'pending', 'rejected']
  }).notNull()
})

export type sqlEvent = InferInsertModel<typeof event>
export type sqlInvite = InferInsertModel<typeof invite>

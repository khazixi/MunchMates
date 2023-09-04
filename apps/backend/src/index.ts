import express from 'express'
import { apiRouter } from './routes/api'

const app = express()

// TODO: Make this dynamic with environment variables
const port = 3000

app.use(apiRouter)

app.get('/', (_, res) => {
  res.send('Hello')
})

app.listen(port)

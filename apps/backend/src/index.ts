import express from 'express'

const app = express()

// TODO: Make this dynamic with environment variables
const port = 3000

app.get('/', (_, res) => {
  res.send('Hello')
})

app.listen(port)

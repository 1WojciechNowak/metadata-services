package ai.wojciechnowak.unit

import slick.jdbc.H2Profile.api._

object H2Database {
  implicit val db = Database.forConfig("db")
}

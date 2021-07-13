package ai.wojciechnowak

import ai.wojciechnowak.model.Person
import slick.jdbc.H2Profile.api._
import ai.wojciechnowak.schema.PersonsSchema

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

trait InitialData {
  self: PersonsSchema =>

  def db: Database

  def insertInitialData(): Future[Unit] = {
    val setup = DBIO.seq(
      persons.delete,

      persons ++= Seq(
        Person(None, "John", "Smith"),
        Person(None, "George", "Washington")
      )
    )

    db.run(setup).andThen {
      case Success(_) => println(s"Initial data inserted")
      case Failure(e) => println(s"Initial data not inserted: ${e.getMessage}")
    }
  }
}

package ai.wojciechnowak

import ai.wojciechnowak.dao.PersonDao
import ai.wojciechnowak.schema.PersonsSchema
import slick.jdbc.H2Profile.api._
import slick.jdbc.meta.MTable

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.Success
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App with PersonsSchema with InitialData {

  val db = Database.forConfig("h2")

  val future = createSchemaIfNotExists().flatMap(_ => insertInitialData())
  Await.ready(future, Duration.Inf)

  val dao = new PersonDao(db)

  printResults(dao.findAll())

  def printResults[T](f: Future[Iterable[T]]): Unit = {
    Await.result(f, Duration.Inf).foreach(println)
    println()
  }

  def createSchemaIfNotExists(): Future[Unit] = {
    db.run(MTable.getTables).flatMap {
      case tables if tables.isEmpty =>
        val schema = persons.schema
        db.run(schema.create).andThen {
          case Success(_) => println("Schema created")
        }
      case tables if tables.nonEmpty =>
        println("Schema already exists")
        Future.successful()
    }
  }
}

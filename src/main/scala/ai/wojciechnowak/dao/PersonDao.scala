package ai.wojciechnowak.dao

import ai.wojciechnowak.model.Person
import ai.wojciechnowak.schema.PersonsSchema
import slick.jdbc.H2Profile.api._

import scala.concurrent.Future

class PersonDao(db: Database) extends PersonsSchema {

  def findPersonById(id: Long): Future[Seq[Person]] = {
    val query = persons.filter(_.id === id)

    query.result.statements.foreach(println)
    db.run(query.result)
  }

  def findAll(): Future[Seq[Person]] = {
    db.run(persons.result)
  }
}

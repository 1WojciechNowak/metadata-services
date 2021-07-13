package ai.wojciechnowak.schema

import ai.wojciechnowak.model.Person
import slick.jdbc.H2Profile.api._

trait PersonsSchema {
  class Persons(tag: Tag) extends Table[Person](tag, "PERSONS") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def firstName = column[String]("FIRST_NAME")
    def lastName = column[String]("LAST_NAME")
    def * = (id.?, firstName, lastName)<>(Person.tupled, Person.unapply)
  }
  val persons = TableQuery[Persons]
}

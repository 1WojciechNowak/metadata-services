package ai.wojciechnowak.unit.dao

import ai.wojciechnowak.dao.PersonDao
import ai.wojciechnowak.unit.data.PersonData
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import ai.wojciechnowak.unit.H2Database.db

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class PersonDaoSpec extends AnyFlatSpec
  with BeforeAndAfterAll
  with PersonData {

  override def beforeAll(): Unit = {
    Await.result(insertTestData(), Duration.Inf)
  }

  val dao = new PersonDao(db)

  it should "findAllPersons" in {
    printResults(dao.findAll())
  }

  def printResults[T](f: Future[Iterable[T]]): Unit = {
    Await.result(f, Duration.Inf).foreach(println)
  }

}

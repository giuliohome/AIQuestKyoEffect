import kyo.consoles._
import kyo.quests._
import kyo.ais._
import kyo._
import kyo.requests._ 

import kyo.core._
import kyo.envs._
import kyo.ios._
import kyo.concurrent.fibers._
import scala.concurrent.duration.Duration

import cats.effect.kernel.Deferred

import org.slf4j.Logger
import org.slf4j.LoggerFactory


case class Ingredient(name:String, quantity: Int)
case class Step (
  description: String,
  minutes: Int,
  ingredients: Set[Ingredient]
)
case class Recipe(name: String, steps: List[Step])

val quest = Quests.select[Recipe]("Recipe for sea bass")

object Hello extends KyoApp {
  def run(args: List[String])  = {
    
    Requests.run {
      AIs.run {
        AIs.init { ai =>
          Quests.run(ai)(quest) { r =>
            Consoles.println(ai.dump(_ + "\n" + r))
          }.unit
        }
      }
    }

  }
}


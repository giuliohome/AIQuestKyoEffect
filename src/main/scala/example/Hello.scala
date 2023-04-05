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


object Hello {
  def main(args: Array[String]): Unit  = {
    val logger = LoggerFactory.getLogger(classOf[KyoApp])
    val quest = Quests.select[Recipe]("Italian recipe")
    val rn = Quests.run(quest)
    val ai = AIs.run(rn) 
    val rq = Requests.run(ai)
    val io = Fibers.forkFiber(rq)
    val fb:Fiber[Recipe] = IOs.run(io) 

    //Fibers.run(fb.join(f => logger.info(f.name)))
    val bl:(Recipe > IOs) = fb.block
    val res:Recipe = IOs.run(bl)
    println(s"recipe is  ${res} !")


    //logger.info(s"$quest")
    /*val rn = Quests.run(quest)
    val ar = AIs.run(rn) 
    val rr = Requests.run(ar)
    val fb = Fibers.run(x => rr(x))
    val io = IOs.run(fb)
    val app =  KyoApp.run(Duration.Inf)(io) */
  }
}


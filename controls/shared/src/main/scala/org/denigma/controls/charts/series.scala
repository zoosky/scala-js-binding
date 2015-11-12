package org.denigma.controls.charts

import scala.collection.immutable.List


case class Point(x: Double, y: Double)


case class StepSeries(title: String,
                      xMin: Double, xMax: Double, stepLength: Double,
                      style: LineStyles = LineStyles.default
                     )(fun: Double => Point) extends Series
{

  lazy val length = xMax - xMin

  //lazy val stepLength = length / steps
  lazy val steps: Int = (length / stepLength).toInt

  val points: List[Point] = (for(
    i<- 0 until steps
  ) yield fun(xMin + i*stepLength) ).toList

}

case class LineSeries(title: String,
                      xMin: Double, xMax: Double,
                      style: LineStyles = LineStyles.default
                     )(fun: Double => Point) extends Series
{
  val points: List[Point] = List(fun(xMin), fun(xMax))
}


case class StaticSeries(title: String,
                        points: List[Point],
                        style: LineStyles = LineStyles.default) extends Series

trait Series
{
  val title: String
  val points: List[Point]
  val style: LineStyles
}
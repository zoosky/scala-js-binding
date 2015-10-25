package org.denigma.preview.slides

import org.denigma.binding.binders.Events
import org.denigma.binding.extensions._
import org.denigma.binding.views.BindableView
import org.scalajs.dom
import org.scalajs.dom.DOMParser
import org.scalajs.dom.ext._
import org.scalajs.dom.raw.Element
import rx.core.Var

import scala.util._

class CollectionSlide(val elem:Element) extends BindableView{

  def parseHTML(string:String): Option[Element] ={
    val p = new  DOMParser()
    Try {
      p.parseFromString(string, "text/html")
    } match {
      case Success(doc)=>
        dom.document.body.children.collectFirst{case html:Element=>html}

      case Failure(th)=>
        dom.console.error(th.toString)
        None
    }
  }

  override def name = "COLLECTION_SLIDE"

  val code = Var("")
  val apply = Var(Events.createMouseEvent())
  this.apply.handler {
      this.findView("testmenu") match {
        case Some(view:BindableView)=>
          dom.console.log("ID IS = "+view.id)
          dom.console.log("HTML is = "+view.elem.outerHTML)

          this.parseHTML(code.now).foreach{case c=>
            dom.console.log("CODE NOW IS"+code.now)
            dom.console.log("CODE HTML"+c.outerHTML)
            view.refreshMe(c)
          }
        case _=>dom.console.error("test menu not found")
  }
  }

}
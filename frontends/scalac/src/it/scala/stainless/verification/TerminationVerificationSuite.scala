/* Copyright 2009-2016 EPFL, Lausanne */

package stainless
package verification

class TerminationVerificationSuite extends ComponentTestSuite {

  val component = VerificationComponent

  override protected def optionsString(options: inox.Options): String = ""

  testAll("termination/valid") { (report, reporter) =>
    for ((vc, vr) <- report.vrs) {
      if (vr.isInvalid) fail(s"The following verification condition was invalid: $vc @${vc.getPos}")
      if (vr.isInconclusive) fail(s"The following verification condition was inconclusive: $vc @${vc.getPos}")
    }
    reporter.terminateIfError()
  }
}

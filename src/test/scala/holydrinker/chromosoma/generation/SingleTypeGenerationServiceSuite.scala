package holydrinker.chromosoma.generation

import holydrinker.chromosoma.model.{ BooleanRule, DistributionValue, RangeRule, StringSetRule }
import munit.FunSuite

class SingleTypeGenerationServiceSuite extends FunSuite {

  test("Basic integer generation") {

    val rules = List(
      RangeRule(Range(10, 100), DistributionValue(1.0))
    )

    val generatedInt = IntegerService.generate(rules)
    assert(generatedInt >= 10 && generatedInt <= 100)
  }

  test("Basic decimal generation") {

    val rules = List(
      RangeRule(Range(10, 100), DistributionValue(1.0))
    )

    val generatedInt = DecimalService.generate(rules)
    assert(generatedInt >= 10 && generatedInt <= 100)
  }

  test("Basic boolean generation") {
    val trueValue = BooleanService.generate(
      List(
        BooleanRule(falseDistribution = DistributionValue(0), trueDistribution = DistributionValue(1))
      )
    )
    assert(trueValue)

    val falseValue = BooleanService.generate(
      List(
        BooleanRule(falseDistribution = DistributionValue(1), trueDistribution = DistributionValue(0))
      )
    )
    assert(!falseValue)
  }

  test("Basic string generation") {
    val set1 = Set("bass", "guitar", "drums")
    val set2 = Set("voice", "piano")

    val rules = List(
      StringSetRule(set1, DistributionValue(0.5)),
      StringSetRule(set2, DistributionValue(0.5))
    )

    val result = StringService.generate(rules)
    set1.union(set2).contains(result)
  }

}

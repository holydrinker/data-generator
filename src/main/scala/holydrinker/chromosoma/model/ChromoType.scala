package holydrinker.chromosoma.model

/**
  * Represents the types of [[ChromoField]]
  */
sealed trait ChromoType

case object ChromoString extends ChromoType

case object ChromoDecimal extends ChromoType

case object ChromoInt extends ChromoType

case object ChromoBoolean extends ChromoType

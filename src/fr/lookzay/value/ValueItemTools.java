package fr.lookzay.value;

public enum ValueItemTools {
    ThirdPersonRotate1(0),
    ThirdPersonRotate2(90),
    ThirdPersonRotate3(-35),
    ThirdPersonTranslation1(0),
    ThirdPersonTranslation2(1.25),
    ThirdPersonTranslation3(-3.5),
    ThirdPersonScale(0.85);

    private double value;

    ValueItemTools(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

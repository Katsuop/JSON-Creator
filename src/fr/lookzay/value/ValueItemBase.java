package fr.lookzay.value;

public enum ValueItemBase {
    ThirdPersonRotate1(-90.0),
    ThirdPersonRotate2(0),
    ThirdPersonRotate3(0),
    ThirdPersonTranslation1(0),
    ThirdPersonTranslation2(1),
    ThirdPersonTranslation3(-3),
    ThirdPersonScale(0.55),
    FirstPersonRotate1(0),
    FirstPersonRotate2(-135),
    FirstPersonRotate3(25),
    FirstPersonTranslation1(0),
    FirstPersonTranslation2(4),
    FirstPersonTranslation3(2),
    FirstPersonScale(1.7);

    private double value;

    ValueItemBase(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

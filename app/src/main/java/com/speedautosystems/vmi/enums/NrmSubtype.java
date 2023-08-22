package com.speedautosystems.vmi.enums;

/**
 * Created by Rameel on 20/04/2021.
 */
public enum NrmSubtype {

    Workshop_Maintenance(1),
    Workshop_Repair(2),
    Workshop_AccidentRepair(3),
    Workshop_Inspection(10),

    NRM_General(4),
    NRM_StaffCar(5),
    NRM_SoldCarCustomerMovement(6),
    NRM_NRT(7),
    NRM_AgreementDelivery(8),
    NRM_ReplacementDelivery(9),
    NRM_AgreementCollection(11),
    NRM_ReplacementCollection(12);


    public final int id;

    NrmSubtype(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}

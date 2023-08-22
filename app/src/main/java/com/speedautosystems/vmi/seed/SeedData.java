package com.speedautosystems.vmi.seed;

import com.speedautosystems.vmi.configuration.HomeCard;
import com.speedautosystems.vmi.configuration.HomeCardButton;
import com.speedautosystems.vmi.configuration.HomeConfig;
import com.speedautosystems.vmi.configuration.ScreenConfig;
import com.speedautosystems.vmi.configuration.Step;
import com.speedautosystems.vmi.enums.ScreenType;
import com.speedautosystems.vmi.enums.StepType;
import com.speedautosystems.vmi.enums.ViewType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 11:53 am
 */
public class SeedData {


    private static final ScreenConfig CHECKLIST = new ScreenConfig(2, ScreenType.CHECKLIST);
    private static final ScreenConfig MARK_EXTERIOR = new ScreenConfig(3, ScreenType.MARK_EXTERIOR);
    private static final ScreenConfig MARK_INTERIOR = new ScreenConfig(4, ScreenType.MARK_INTERIOR);
    private static final ScreenConfig SIGNTAURE = new ScreenConfig(5, ScreenType.SIGNTAURE);
    private static final ScreenConfig REPORTS = new ScreenConfig(1, ScreenType.REPORTS);

    private static final ScreenConfig NRM_OUT_MOVEMENT = new ScreenConfig(1, ScreenType.MOVEMENT, new ArrayList<>(Arrays.asList(ViewType.VEHICLE, ViewType.VEHICLE_MAKE_MODEL, ViewType.KM_FIRST, ViewType.FUEL_FIRST, ViewType.DRIVER, ViewType.SIMPLE, ViewType.SIMPLE, ViewType.BRANCH)));
    private static final ScreenConfig NRM_IN_MOVEMENT = new ScreenConfig(1, ScreenType.MOVEMENT, new ArrayList<>(Arrays.asList(ViewType.VEHICLE, ViewType.VEHICLE_MAKE_MODEL, ViewType.KM_FIRST, ViewType.FUEL_FIRST, ViewType.KM_SECOND, ViewType.FUEL_SECOND, ViewType.DRIVER, ViewType.BRANCH)));
    private static final ScreenConfig INSPECTION_MOVEMENT = new ScreenConfig(1, ScreenType.MOVEMENT, new ArrayList<>(Arrays.asList(ViewType.VEHICLE, ViewType.VEHICLE_MAKE_MODEL, ViewType.KM_FIRST, ViewType.FUEL_FIRST, ViewType.DRIVER, ViewType.BRANCH)));
    private static final ScreenConfig GARAGE_IN_MOVEMENT = new ScreenConfig(1, ScreenType.MOVEMENT, new ArrayList<>(Arrays.asList(ViewType.VEHICLE, ViewType.VEHICLE_MAKE_MODEL, ViewType.KM_FIRST, ViewType.FUEL_FIRST, ViewType.DRIVER, ViewType.CUSTOMER, ViewType.WORKSHOP, ViewType.BRANCH)));
    private static final ScreenConfig GARAGE_OUT_MOVEMENT = new ScreenConfig(1, ScreenType.MOVEMENT, new ArrayList<>(Arrays.asList(ViewType.VEHICLE, ViewType.VEHICLE_MAKE_MODEL, ViewType.KM_FIRST, ViewType.FUEL_FIRST, ViewType.KM_SECOND, ViewType.FUEL_SECOND, ViewType.DRIVER, ViewType.CUSTOMER, ViewType.WORKSHOP, ViewType.BRANCH)));

    private static final Step inspection_step = new Step("INSPECTION", StepType.FIRST, new ArrayList<>(Arrays.asList(INSPECTION_MOVEMENT, CHECKLIST, MARK_EXTERIOR, MARK_INTERIOR, SIGNTAURE)));
    private static final HomeCardButton inspection_option = new HomeCardButton(1, inspection_step, "ok");
    private static final HomeCard inspection = new HomeCard(1, 1, 1, "inspection", inspection_option);
    private static final Step nrm_step_out = new Step("NRM OUT", StepType.FIRST, new ArrayList<>(Arrays.asList(NRM_OUT_MOVEMENT, CHECKLIST, MARK_EXTERIOR, MARK_INTERIOR, SIGNTAURE)));
    private static final HomeCardButton nrm_option_first = new HomeCardButton(1, nrm_step_out, "check-out");
    private static final Step nrm_step_in = new Step("NRM IN", StepType.SECOND, new ArrayList<>(Arrays.asList(NRM_IN_MOVEMENT, CHECKLIST, MARK_EXTERIOR, MARK_INTERIOR, SIGNTAURE)));
    private static final HomeCardButton nrm_option_second = new HomeCardButton(2, nrm_step_in, "check-in");
    private static final HomeCard nrm = new HomeCard(2, 2, 2, "staff-movement", nrm_option_first, nrm_option_second);
    private static final Step garage_step_in = new Step("GARAGE IN", StepType.FIRST, new ArrayList<>(Arrays.asList(GARAGE_IN_MOVEMENT, CHECKLIST, MARK_EXTERIOR, MARK_INTERIOR, SIGNTAURE)));
    private static final HomeCardButton garage_option_first = new HomeCardButton(1, garage_step_in, "garage-in");
    private static final Step garage_step_out = new Step("GARAGE OUT", StepType.SECOND, new ArrayList<>(Arrays.asList(GARAGE_OUT_MOVEMENT, CHECKLIST, MARK_EXTERIOR, MARK_INTERIOR, SIGNTAURE)));
    private static final HomeCardButton garage_option_second = new HomeCardButton(2, garage_step_out, "garage-out");
    private static final HomeCard garage = new HomeCard(3, 3, 2, "workshop-movement", garage_option_first, garage_option_second);
    private static final Step report_step = new Step("REPORTS", StepType.FIRST, new ArrayList<>(Collections.singletonList(REPORTS)));
    private static final HomeCardButton report_option = new HomeCardButton(1, report_step, "ok");
    private static final HomeCard report = new HomeCard(4, 1, 1, "Reports", report_option);

    public static final HomeConfig HOME_CONFIG = new HomeConfig(2, new ArrayList<>(Arrays.asList(nrm, inspection, garage, report)));
}

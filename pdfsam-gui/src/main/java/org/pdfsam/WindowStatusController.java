/*
 * This file is part of the PDF Split And Merge source code
 * Created on 08/ott/2014
 * Copyright 2017 by Sober Lemur S.a.s. di Vacondio Andrea (info@pdfsam.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam;

import javax.inject.Inject;

import org.pdfsam.ui.StageService;
import org.pdfsam.ui.StageStatus;
import org.sejda.injector.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Controller for the Window status
 *
 * @author Andrea Vacondio
 *
 */
@Auto
class WindowStatusController {
    private WindowStatusControllerStageStatus windowStatusControllerStageStatus = new WindowStatusControllerStageStatus();
    private static final Logger LOG = LoggerFactory.getLogger(WindowStatusController.class);
    public static final String PDFSAM_DISABLE_UI_RESTORE = "org.pdfsam.disable.ui.restore";

    private StageService service;

    @Inject
    WindowStatusController(StageService service) {
        this.service = service;
    }
    public void setStage(Stage stage) {
        windowStatusControllerStageStatus.setStage(stage, this);
    }
    public void initUi() {
        StageStatus latestStatus = service.getLatestStatus();
        if (!Boolean.getBoolean(PDFSAM_DISABLE_UI_RESTORE) && !StageStatus.NULL.equals(latestStatus)
                && hasAvailableScreen(latestStatus)) {
            windowStatusControllerStageStatus.restore(latestStatus);
            LOG.trace("Stage status restored to {}", latestStatus);
        } else {
            windowStatusControllerStageStatus.defaultStageStatus();
            LOG.trace("Stage status set to default values");
        } }

    private boolean hasAvailableScreen(StageStatus status) {
        return !Screen.getScreensForRectangle(status.getX(), status.getY(), status.getWidth(), status.getHeight())
                .isEmpty();
    }
}

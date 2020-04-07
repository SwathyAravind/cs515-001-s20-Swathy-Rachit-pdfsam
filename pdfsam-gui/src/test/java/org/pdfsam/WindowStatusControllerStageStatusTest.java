package org.pdfsam;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.junit.Before;
import org.junit.Test;
import org.pdfsam.ui.StageService;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import javafx.stage.Stage;


import org.pdfsam.ui.StageStatus;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class WindowStatusControllerStageStatusTest extends ApplicationTest {
    private StageService service;
    private WindowStatusController windowStatusController;
    private WindowStatusControllerStageStatus victim;
    private Stage victimStage;

    @Override
    public void start(Stage stage) {
        victimStage = new Stage();
        victimStage.setScene(new Scene(new VBox()));

        service = mock(StageService.class);
        windowStatusController = new WindowStatusController(service);
        victim = new WindowStatusControllerStageStatus();

        Button button = new Button("show");
        button.setOnAction(a -> victimStage.show());
        Scene scene = new Scene(new HBox(button));
        stage.setScene(scene);
        stage.show();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void defaultStageStatusValue() {
        when(service.getLatestStatus()).thenReturn(StageStatus.NULL);
        System.setProperty(WindowStatusController.PDFSAM_DISABLE_UI_RESTORE, Boolean.TRUE.toString());
        windowStatusController.setStage(victimStage);
        boolean isNan = Double.isNaN(victimStage.getWidth());
        assertTrue("default state of stage should be NaN for height, width, X and Y", isNan);
    }

    @Test
    public void defaultStageShouldBeMaximized() {
        when(service.getLatestStatus()).thenReturn(new StageStatus(0, 0, 0, 0));
        System.setProperty(WindowStatusController.PDFSAM_DISABLE_UI_RESTORE, Boolean.TRUE.toString());
        windowStatusController.setStage(victimStage);
        clickOn("show").sleep(500);
        assertTrue("Default value of stage should be maximized", victimStage.isMaximized());
    }

    @Test
    public void restore() {
        when(service.getLatestStatus()).thenReturn(new StageStatus(100, 100, 100, 100));
        windowStatusController.setStage(victimStage);
        clickOn("show").sleep(500);
        assertEquals("Restored state of stage should be set with provided height", 100,  victimStage.getHeight(), 0.00);
        assertEquals("Restored state of stage should be set with provided width", 100, victimStage.getWidth(), 0.00);
    }
}
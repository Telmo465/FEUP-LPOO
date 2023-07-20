package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.game.RndMapController;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.view.game.GameViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class RndGameStateTest {

    @Test
    void initState() {
        Map map = Mockito.mock(Map.class);
        RndGameState state = new RndGameState(map);

        assertEquals(map, state.getModel());
        assertEquals(GameViewer.class, state.getViewer().getClass());
        assertEquals(map, state.getViewer().getModel());
        assertEquals(RndMapController.class, state.getController().getClass());
        assertEquals(map, state.getController().getModel());
    }
}

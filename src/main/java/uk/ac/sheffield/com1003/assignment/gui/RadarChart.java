package uk.ac.sheffield.com1003.assignment.gui;

import uk.ac.sheffield.com1003.assignment.codeprovided.AbstractPlayerCatalog;
import uk.ac.sheffield.com1003.assignment.codeprovided.PlayerEntry;
import uk.ac.sheffield.com1003.assignment.codeprovided.PlayerProperty;
import uk.ac.sheffield.com1003.assignment.codeprovided.gui.AbstractRadarChart;
import uk.ac.sheffield.com1003.assignment.codeprovided.gui.RadarAxisValues;

import java.util.*;

/**
 * SKELETON IMPLEMENTATION
 */

public class RadarChart extends AbstractRadarChart {
    public RadarChart(AbstractPlayerCatalog playerCatalog, List<PlayerEntry> filteredPlayerEntriesList, List<PlayerProperty> playerRadarChartProperties) {
        super(playerCatalog, filteredPlayerEntriesList, playerRadarChartProperties);
    }

    @Override
    public void updateRadarChartContents(List<PlayerProperty> radarChartPlayerProperties, List<PlayerEntry> filteredPlayerEntriesList) {
        radarAxesValues.clear();
        filteredPlayerEntries = filteredPlayerEntriesList;
        playerRadarChartProperties = radarChartPlayerProperties;
        if (filteredPlayerEntriesList.size() < 1) return;
        for (PlayerProperty playerProperty : radarChartPlayerProperties) {
            double min = playerCatalog.getMinimumValue(playerProperty, filteredPlayerEntriesList);
            double max = playerCatalog.getMaximumValue(playerProperty, filteredPlayerEntriesList);
            double avg = playerCatalog.getMeanAverageValue(playerProperty, filteredPlayerEntriesList);
            radarAxesValues.put(playerProperty, new RadarAxisValues(min, max, avg));
        }
    }

    @Override
    public List<PlayerProperty> getPlayerRadarChartProperties() throws NoSuchElementException {
        return playerRadarChartProperties;
    }

    @Override
    public Map<PlayerProperty, RadarAxisValues> getRadarPlotAxesValues() throws NoSuchElementException {
        Map<PlayerProperty, RadarAxisValues> plotValues = new HashMap<>();
        for (PlayerProperty playerProperty : playerRadarChartProperties) {
            if (radarAxesValues.get(playerProperty) == null) continue;
            plotValues.put(playerProperty, radarAxesValues.get(playerProperty));
        }
        return plotValues;
    }

    @Override
    public AbstractPlayerCatalog getPlayerCatalog() {
        return playerCatalog;
    }

    @Override
    public List<PlayerEntry> getFilteredPlayerEntries() {
        return filteredPlayerEntries;
    }

}


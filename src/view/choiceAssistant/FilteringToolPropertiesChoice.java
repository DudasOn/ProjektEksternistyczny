package view.choiceAssistant;

import view.MainFrame;

import javax.swing.*;

public class FilteringToolPropertiesChoice extends ToolChoiceFrame {



    public FilteringToolPropertiesChoice() {
        super();

        this.setTitle("Choose a filtering tool");


        okButton.addActionListener(e -> {
            this.setVisibility();
            this.informOfFilterChange();
        });

        topPanel.add(chooseToolAtributeInfo);
        topPanel.add(toolAtriuteSlider);


        bottomPanel.add(okButton);

        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
        this.pack();
    }

    public void registerToolGatherer(MainFrame toolGatherer) {
        this.toolGatherer = toolGatherer;
    }

    public void informOfFilterChange() {
        toolGatherer.changeFilter();
    }

}

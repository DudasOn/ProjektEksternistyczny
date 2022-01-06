package view.choiceAssistant;

import view.MainFrame;

import javax.swing.*;

public class FilteringToolPropertiesChoice extends ToolChoiceFrame {

    private boolean ifAppliedToEntireImage;
    private int chosenFilterType;
    private JRadioButton brightenRadioButton;
    private JRadioButton darkenRadioButton;
    private JRadioButton grayScaleRadioButton;
    private JRadioButton invertedColorsRadioButton;
    private JRadioButton sepiaRadioButton;
    private JRadioButton entireImageRadioButton;
    private JRadioButton selectedSizeRadioButton;


    public FilteringToolPropertiesChoice() {
        super();

        this.setTitle("Choose a filtering tool");

        brightenRadioButton = new JRadioButton("Brighten");
        darkenRadioButton = new JRadioButton("Darken");
        grayScaleRadioButton = new JRadioButton("Gray scale");
        invertedColorsRadioButton = new JRadioButton("Invert colors");
        sepiaRadioButton = new JRadioButton("Sepia");
        entireImageRadioButton = new JRadioButton("Apply to entire picture");
        selectedSizeRadioButton = new JRadioButton("Apply according to tool size");

        brightenRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            brightenRadioButton.setSelected(true);
        });

        darkenRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            darkenRadioButton.setSelected(true);
        });

        grayScaleRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            grayScaleRadioButton.setSelected(true);
        });

        invertedColorsRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            invertedColorsRadioButton.setSelected(true);
        });

        sepiaRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            sepiaRadioButton.setSelected(true);
        });

        entireImageRadioButton.addActionListener(e -> {
            entireImageRadioButton.setSelected(true);
            selectedSizeRadioButton.setSelected(false);
            ifAppliedToEntireImage = true;
        });

        selectedSizeRadioButton.addActionListener(e -> {
            selectedSizeRadioButton.setSelected(true);
            entireImageRadioButton.setSelected(false);
            ifAppliedToEntireImage = false;

        });


        okButton.addActionListener(e -> {
            this.setVisibility();
            this.informOfFilterChange();
        });

        topPanel.add(chooseToolAtributeInfo);
        topPanel.add(toolAtriuteSlider);

        middlePanel.add(brightenRadioButton);
        middlePanel.add(darkenRadioButton);
        middlePanel.add(grayScaleRadioButton);
        middlePanel.add(invertedColorsRadioButton);
        middlePanel.add(sepiaRadioButton);

        bottomPanel.add(entireImageRadioButton);
        bottomPanel.add(selectedSizeRadioButton);
        bottomPanel.add(okButton);

        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
        this.pack();
    }

    private void allFilteringJRadioButtonsToFalse() {
        brightenRadioButton.setSelected(false);
        darkenRadioButton.setSelected(false);
        grayScaleRadioButton.setSelected(false);
        invertedColorsRadioButton.setSelected(false);
        sepiaRadioButton.setSelected(false);
    }

    public void registerToolGatherer(MainFrame toolGatherer) {
        this.toolGatherer = toolGatherer;
    }

    public void informOfFilterChange() {
        toolGatherer.changeFilter();
    }

}

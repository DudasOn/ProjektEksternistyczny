package view.choiceAssistant;

import javax.swing.*;

public class FilteringToolPropertiesChoice extends ToolChoiceFrame {

    private boolean ifAppliedToEntireImage = true;
    private int chosenFilterType = 1;
    private final JRadioButton brightenRadioButton; //type 1
    private final JRadioButton darkenRadioButton; //type 2
    private final JRadioButton grayScaleRadioButton; //type 3
    private final JRadioButton invertedColorsRadioButton; //type 4
    private final JRadioButton sepiaRadioButton; //type 5
    private final JRadioButton entireImageRadioButton;
    private final JRadioButton selectedSizeRadioButton;


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

        brightenRadioButton.setSelected(true);
        entireImageRadioButton.setSelected(true);


        brightenRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            brightenRadioButton.setSelected(true);
            chosenFilterType = 1;
        });

        darkenRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            darkenRadioButton.setSelected(true);
            chosenFilterType = 2;
        });

        grayScaleRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            grayScaleRadioButton.setSelected(true);
            chosenFilterType = 3;
        });

        invertedColorsRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            invertedColorsRadioButton.setSelected(true);
            chosenFilterType = 4;
        });

        sepiaRadioButton.addActionListener(e -> {
            this.allFilteringJRadioButtonsToFalse();
            sepiaRadioButton.setSelected(true);
            chosenFilterType = 5;
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

        topPanel.add(chooseToolAttributeInfo);
        topPanel.add(toolAttriuteSlider);

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

    public void informOfFilterChange() {
        toolGatherer.changeFilter();
    }

    public int[] getFilter() {
        return new int[]{toolAttriuteSlider.getValue(), chosenFilterType};
    }

    public boolean getIfAppliedToEntireImage(){
        return ifAppliedToEntireImage;
    }

}

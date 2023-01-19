# My Plant Diary

Brandan Jones

## Introduction

Do you remember when you planted the apple tree?  Do you know when to water and fertilize your plants? MyPlantDiary can help you:
-	Record dates and locations where you planted plants.
-	Take and view photos of a plant throughout its life.
-	Record when you added water, fertilizer, and other amendments.
-	Be aware of upcoming events for a plant: when to water, when growing season ends, etc.
Use your Android device to create your own plant diary.  Take photos with the on-device camera.  Create reminders based on what you did in previous years.   Receive alerts about upcoming events for your plant.

## Storyboard

## Functional Requirements

### Requirement 100.0: Search for Plants

#### Scenario
As a user interested in plants, I want to be able to search plants based on any part of the name: genus, species, cultivar, or common name.
#### Dependencies
Plant search data are available and accessible.
####  Assumptions
Scientific names are stated in Latin.
Common names are stated in English.
###### Examples
1.1
**Given** a feed of plant data is available
**When** I search for “Redbud”
**Then** I should receive at least one result with these attributes: 
Genus: Cercis
Species: canadensis
Common: Eastern Redbud 
1.2
**Given** a feed of plant data is available
**When** I search for “Quercus”
**Then** I should receive at least one result with these attributes: 
Genus: Quercus
Species: robur
Common: English Oak
And I should receive at least one result with these attributes:
Genus: Quercus
Species: alba
Common: White Oak

1.3
**Given** a feed of plant data is available
**When** I search for “sklujapouetllkjsda;u”
**Then** I should receive zero results (an empty list)

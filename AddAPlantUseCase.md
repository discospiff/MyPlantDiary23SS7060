# Add Plant Use Case
![Use Case Diagram](https://github.com/discospiff/MyPlantDiary23SS7060/blob/1634a08fd98c95af08a4b1e16ec72a7398f5b9a5/MyPlantDiaryUseCase.jpg)

**Use Case Name:** Add a Plant
**Importance Level:** High

## Stakeholders and Interests
- My Plant Diary User
- Device
- Cloud Storage

## Description
When a user adds a specimen, we want to record it on the local device and in the cloud.
From the cloud, we can associate the specimen with maintenance records for that type of plant.

## Trigger
User adds a specimen of a plant on the MPD app.

## Natural Flow of Events

 - User opens MPD app.
 - User searches for a plant using AutoComplete - from the PlantPlaces.com database
 - User selects a plant
 - User enters details for a specimen planted (GPS, date planted, etc.)
 - Optional: User uploads photos of plant
 - User presses save
		- If logged in, trigger the save routine.
		- If not logged in, trigger the login routine.
 - Specimen record stores locally
 - Specimen record syncs to cloud (parallel)
 - Photos resized and watermarked on device, then uploaded (parallel)
 - On the cloud: plant is matched to maintenance records
 - Alert schedule updated.


## Subflows
- Login
- Sync to cloud

## Alternate/Exception Flows
 - Plant record doesn't exist
 - Maintenance record doesn't exist
 - Device is offline
 - User is not logged in
 - User does not login.
 - Device is out of storage

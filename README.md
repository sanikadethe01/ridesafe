# RideSafe 🏍️

RideSafe is an Android application designed to keep family members informed during long-distance motorcycle rides.

The app automatically tracks the rider's location using GPS and periodically sends SMS updates containing the rider's current location and estimated arrival time (ETA) to selected family contacts.

## Problem Statement

During long motorcycle journeys, family members often worry about the rider's safety and arrival status. Riders may also forget to send regular updates while focusing on the road.

RideSafe solves this problem by automatically sharing ride progress and ETA updates without requiring manual interaction during the journey.

## Features

### MVP Features

* Rider Login
* Family Contact Management
* Ride Setup Screen
* GPS-based Location Tracking
* ETA Calculation
* Automatic SMS Updates
* Periodic Ride Status Notifications
* Ride Completion Notification
* Modern Jetpack Compose UI

### Future Enhancements

* Crash Detection
* SOS Emergency Alerts
* WhatsApp Notifications
* AI-based ETA Prediction
* Traffic-aware Route Analysis
* Ride History Dashboard
* Family Tracking Portal

## Technology Stack

### Frontend

* Kotlin
* Jetpack Compose
* Material Design 3

### Backend

* Firebase Authentication
* Firebase Firestore
* Firebase Cloud Messaging

### Android Services

* Fused Location Provider
* WorkManager
* Runtime Permissions

### SMS Service

* MSG91 API

## Project Workflow

1. User logs into the application.
2. Family contacts are added.
3. Rider starts a journey.
4. GPS tracking begins.
5. WorkManager periodically fetches location data.
6. ETA is calculated.
7. SMS updates are sent to family members.
8. Ride completion message is delivered automatically.

## Project Structure

```text
ui/
navigation/
data/
services/
worker/
utils/
```

## Target Users

* Motorcycle Riders
* Long-Distance Travelers
* Delivery Riders
* Family Members of Travelers

## Goal

To provide peace of mind to families by automatically sharing ride progress and estimated arrival information throughout the journey.

```
```

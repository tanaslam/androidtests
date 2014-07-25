#!/bin/sh

##
# The script launches an already configured android virtual device (AVD)
# and run connected tests on it 

#Check if valid android virtual device name is provided
if [ -z "$1" ]
then
	echo "You must provide valid android virtual device name:"
	android list avd
	exit
fi 

# Run emulator in separate and return 
echo "Starting emulator @$1 virtual device..."
emulator -no-window -noaudio -no-boot-anim @$1 &

# Make adb to wait for device to become online
echo "Waiting to emulator to become online..."
adb -s emulator-5554 wait-for-device

# Run gradle connectedAndroidTest task
echo "Emulator is online. Running automated tests..."
./gradlew connectedAndroidTest

# Shutdown emulator
echo "Test complete. Stopping emulator..."
adb emu kill  
if [$? = 0];
then
	echo "Done!"
fi



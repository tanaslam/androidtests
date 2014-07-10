#!/bin/sh

##
# The script launches an already configured android virtual device (AVD)
# and run connected tests on it 

# Run emulator in separate and return 
echo "Starting emulator..."
emulator -no-window -noaudio -no-boot-anim @Nexus_4_by_Google&

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



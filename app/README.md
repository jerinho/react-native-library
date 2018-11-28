# scaffolding codebase for react native
- react native version : 0.55.4
- as for now this is for WINDOWS only
- as for now this is for ANDROID only
- for native react native 's installation only. expo based project not supported
- let me know if there exists any later versions of react native with the same stability and maturity you found somewhere. thank you

# requirement
- windows
- elevated privilege console (cmd)
- nodejs + npm
- yarn (`npm i -g yarn`)
- react-native (`npm i -g react-native`)

# installation
1. copy this repo to a local working directory
2. edit `android/local.properties`. set `sdk.dir` to your android sdk directory location
3. go to working directory from console
4. `yarn`

# run
1. connect device or run android simulator
2. go to working directory from console
3. `react-native run-android`
4. expected : metro bundler console window is running and app is running showing a greeting message
5. if not, don't hesitate to submit your issue here

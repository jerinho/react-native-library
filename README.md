# what is this ?
- this is a scaffolding @ boilerplate @ codebase @ stereotype, whatever name you can come up with ...
- ... for a react native library development, which is by using this, there's no need to call `react-native-create-library` anymore
- ... except if there are any later update released from new command package installation via npm, whether it is stable or not, by then you can call this repository "stable but outdated"

# what it got ?
- react native version supported : 0.41.2
- android support
> - gradle : 1.3.1
> - build tools (default by gradle) : 27.0.3
> - sdk version (compile and target) : 27
- be acknowledged that these are applied to library project only, not to application
- as for now this is for development on windows only
- as for now this is for android only
- for native react native 's installation only. expo based project not supported
- including a scaffolding to develop application project with support for the library development

# what it need ?
- windows
- elevated privilege console (cmd)
- nodejs + npm
- yarn (`npm i -g yarn`)
- react-native (`npm i -g react-native`)

# installation
1. copy this repo to a local working directory. you may rename it as you want. from now it it your library project directory
2. take out directory `app`. that is the directory for application development. put it somewhere else and rename it if you going to use it later. or get rid of it if you don't
3. edit `android/local.properties`. set `sdk.dir` to point to your android sdk directory location
4. edit `package.json`. change `name` to suit your preference and keep prefix `react-native-`. in case if you plan to publish it as online package later, make sure it is not yet registered <a target='_blank' href='https://www.npmjs.com/'>here</a>
5. open up console (command prompt)
6. go to library project directory
7. `yarn`
8. `yarn link`
9. go to application project directory
10. if it is the one from repo, `yarn`
11. if it is an existing project, follow these
> 1. open up `android/app/src/main/java/.../MainApplication.java`
> 2. insert `import com.reactlibrary.ReactLibraryPackage;` to the bottom of the import list
> 3. append `new ReactLibraryPackage()` as an argument of `Arrays.<ReactPackage>asList()` inside `getPackages` function
```
protected List<ReactPackage> getPackages() {
  return Arrays.<ReactPackage>asList(new MainReactPackage(), new ReactLibraryPackage());
}
```
12. if your library name is changed or for existing project, follow these
> 1. open up `android/settings.gradle`
> 2. append or edit below lines with your library name in the blank
```
include ':___'
project(':___').projectDir = new File(rootProject.projectDir, '../node_modules/___/android')
```
> 3. open up `android/app/build.gradle`
> 4. append or edit `compile project(':___')` to the bottom with your library name in the blank
13. `yarn link ___` with name of your library from `package.json` in the blank
14. `yarn publish` on library project directory to publish your library to <a target='_blank' href='https://www.npmjs.com/'>npm.js</a>

# run
1. connect device or run android simulator
2. go to working directory from console
3. `react-native run-android`
4. expected metro bundler console window is running and app is running showing a greeting message

# how to use ?
- i wish i have time for this. maybe next time. for now, please refer <a target='_blank' href='https://facebook.github.io/react-native/docs/native-modules-android'>here</a>

# please
- don't hesitate to submit your issue here

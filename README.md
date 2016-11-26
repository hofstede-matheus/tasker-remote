# tasker-remote
Made to simulate a remote control that fires Tasker tasks with a beautiful interface.
After all base funcionality is implemented I'm going to start making a more useful version.
[@hofstede-matheus](https://github.com/hofstede-matheus)


## Initial release (see issues for more info):
- [x] Fixed cards tha fire predefined tasks.
- [x] Tasks can have fingerprint confimation to run.
- [ ] Tasks are organized in JSON objects.
- [ ] Folder or sections to categorize tasks.
- [ ] Material Style :).




## TODO:
- [ ] Typed passwords for devices that have no fingerprint scanner.
- [ ] Move tasks to folders with finger gestures.
- [ ] Can change through lists, grid and cards.
- [ ] Check if external access is enabled and if tasker is installed on first time app run.
- [ ] Widgets and shortcuts to run from homescreen.
- [ ] Change Tasks icons.


### links
[Tasker Developer](http://tasker.dinglisch.net/developers.html)

[invoking tasks programatically](http://tasker.dinglisch.net/invoketasks.html)

[content provider](http://tasker.dinglisch.net/contentprovider.html)

[plugins](http://tasker.dinglisch.net/plugins.html)

[gson userguide](https://github.com/google/gson/blob/master/UserGuide.md)

### libs used in this project:
[Digitus](https://github.com/afollestad/digitus)
[gson](https://github.com/google/gson)




### json task object
```javascript
{
     "title": "Task Title",
     "desc": "short description of the task",
     "task_name": "Task name is the exactly name of the task in Tasker",
     "category": "To organize",
     "password": "5f4dcc3b5aa765d61d8327deb882cf99",
     "authentication_method": 1
    }
```


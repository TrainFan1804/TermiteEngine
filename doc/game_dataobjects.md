# Data Objects

## Overview

A game contains multiple data objects. Currently, there are two (or three) types.

- rooms
- items
- (player, currently not used)

### Rooms

A room contains following information:

- info
- actions

Actions contains a list of different actions (e.g. exit or look).

| field                          | description                | comment                                             |          |
|--------------------------------|----------------------------|-----------------------------------------------------|----------|
| info/name                      | Name of the room           |                                                     | required |
| info/description               | Message when enter room    |                                                     | required |
| info/image                     |                            |                                                     |          |
| actions/exit/[CUSTOM]/required | Condition to enter room    |                                                     |          |
| actions/exit/[CUSTOM]/target   | The next room              | File name of the next room (without `.json` ending) |          |
| actions/exit/[CUSTOM]/failure  | Failure message            | Must be used with `required`                        |          |
| actions/look/[CUSTOM]/item     | Name of the findable item  | File name of the item (without `.json` ending)      |          |
| actions/look/[CUSTOM]/message  | Message when item is found |                                                     |          |
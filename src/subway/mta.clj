(ns subway.mta
  (:gen-class))

(def stations {:14-st                   [[:6th-ave 71] [:west-4th 151]]
               :6th-ave                 [[:14-st 71] [:union-sq 75]]
               :union-sq                [[:6th-ave 75] [:west-4th 140] [:3rd-ave 118]]
               :3rd-ave                 [[:union-sq 118] [:1st-ave 111]]
               :1st-ave                 [[:3rd-ave 111] [:bedford-ave 70]]
               :bedford-ave             [[:1st-ave 70] [:lorimer-st 75]]
               :lorimer-st              [[:bedford-ave 75] [:graham-ave 120]]
               :graham-ave              [[:lorimer-st 75] [:2nd-ave 146] [:york-st 138]]
               :2nd-ave                 [[:graham-ave 146] [:west-4th 80] [:york-st 97]]
               :west-4th                [[:2nd-ave 80] [:union-sq 140] [:14-st 151] [:fulton-st 99]]
               :fulton-st               [[:west-4th 99] [:jay-st-metrotech 211]]
               :york-st                 [[:2nd-ave 97] [:graham-ave 138] [:jay-st-metrotech 101]]
               :jay-st-metrotech        [[:york-st 101] [:fulton-st 211] [:hoyt-st 85] [:dekalb-ave 90]]
               :dekalb-ave              [[:jay-st-metrotech 90]]
               :hoyt-st                 [[:jay-st-metrotech 85] [:lafayette-ave 142] [:nevins-st 98]]
               :nevins-st               [[:hoyt-st 98] [:atlantic-ave 86]]
               :atlantic-ave            [[:nevins-st 86]]
               :lafayette-ave           [[:hoyt-st 142] [:clinton-washington-aves 92]]
               :clinton-washington-aves [[:lafayette-ave 142] [:franklin-ave 87]]
               :franklin-ave            [[:clinton-washington-aves 87]]})

(def distances-to-jay-st-metrotech {:union-sq                 366
                                    :jay-st-metrotech         0
                                    :graham-ave               160
                                    :lorimer-st               242
                                    :atlantic-ave             161
                                    :fulton-st                176
                                    :dekalb-ave               77
                                    :nevins-st                151
                                    :clinton-washington-aves  226
                                    :1st-ave                  244
                                    :bedford-ave              241
                                    :franklin-ave             234
                                    :14-st                    380
                                    :york-st                  100
                                    :2nd-ave                  193
                                    :west-4th                 253
                                    :3rd-ave                  329
                                    :hoyt-st                  80
                                    :lafayette-ave            199
                                    :6th-ave                  374})

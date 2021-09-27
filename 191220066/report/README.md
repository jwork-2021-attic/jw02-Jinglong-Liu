##作业2说明

###任务1
尝试从面向对象编程角度理解`example`的设计理念，具体阐述这样写的好处与可改进之处（越详细越好）
好处：
    
    解耦合，可复用性好。
    排序就直接排序数组，排序的结果可以向上传递，每个部分只需要完成自己的工作
    Geezer采用单例，避免重复创建实例

可改进之处：
    
    排序可以使用泛型，实现排序所有实现Comparable的类
    example只有7个葫芦实例，可以使用枚举；但实际需要排序的可能远不止7个,无法一一列举，因此采用更普通的类会有更好的普适性

    在处理基于交换的排序时(这里是指严格的两两交换，swap(a,b))效果很好，但其他的排序则要修改较多内容


###代码说明
```java
//Scene.main
        //Sorter sorter = new SelectSorter();
        Sorter sorter = new QuickSorter();
        snake.setSorter(sorter);
        Line line = Monster.getMonsters(12,12);
```
首先选择一种排序算法（给出的是选排和快排）
然后设置排序的妖怪的数量（输入的参数是矩阵行和列，task2排成一行，总数就是二者乘积。现在只测试了行 = 列的情况）
task2下面演示排成一行，task3演示排成一个矩阵

已经生产的四个result，演示了用两种算法分别排成一行和矩阵的情形

###视频：
####一行：
https://asciinema.org/a/LGu3zCgIhET9dcvBqY3mHh7br
####方阵（12*12）
https://asciinema.org/a/txRYf0ar8Kl7dHpmRPEELr3Sq
第一个视频是选择排序，第二个是快速排序(基于交换的)。虽然我们知道快速排序比选择排序快，但是视频展示的是交换的过程，没有展示比较的过程（有待扩展）选择排序虽然比较的次数多，但是交换的次数少，因此“看起来”快。
###类图
__example__
![](
http://www.plantuml.com/plantuml/png/PLFRRjmW47tdAr2Ul1Nx0qqhHP6SD5ALhNOtsqfL7_1wuj1YR77ffLN-lPY14OdzO8QPuPoPCt3blBG-Z9enPJpOHta6VfXiDFa_5ZyUFpt9ledXhzyuQ1Z1UBUvn92BgKtP3E0_QMbepzWpOsSjdUFNeUiqP60rpXc6gF00SiXy_E2jCWEV8oH_poykiXl_7G4IdVibvwLChWHVbkzBuBbkxACoCfugT2xMEpdbrMIQOl0v6zHKbLJvJb87I0xgaI0GdjWqhlaiWRqAKnVWSsILKPF56FLH8ADsfNfNYvMIap8QpE2V2jKS_6iEL4vLZQAYcJknJjijKJ869epyTWgsh-TQAOr8k_jM73_lnF73lct5pUvXBsxkJgqut7qHX_RKtcV6ntXGfoBioZEiF5tshAPtcNcniYRX2GJ1fTjGXodb-izUcX-O60sC9hD1Erql6XusBCtady1kaZReUYaErVKckhCcPOAt07_hLvRt4H0jRAsy49UMwAEoZoMneNbQzLDwuEIc6uKWpGki4jRAmCEyN0H8Dg59wo2zv-eXPYtWDvo3Xn9n7cOK0QcJ2aYMxyosjFUMzo0rVyVO5PW-ZFe_
)
__task2__
![](
http://www.plantuml.com/plantuml/png/fLFDZXCn3BxtAQ8zJH5z0HQa5NlWmag8ibmG1--CQKCpIJR9yACLxuvhEvdPwO43FNHin_w-pqvyamkaCerkqpl8sTm65zBJnj3F-cBITJCFi_aWPX_620a_XMxBVWdxagm_g8kF4xYipX7oyJOCI2xx2Vo9x3zBsljYdL0Vi714Yydz27u88mSLiYNTGMIaXc5sWhSXhPY-GOzc7nAPvad8NO2XeyClNmqw7D6Nl9MMCkLrQXF-1mU-kathdchweeXsZ8hGE3XRq45APImc4ffvOwwkbAlYDCRy4-9Pbx4lUSxVALvP7oVRd_wVL67-nJbFxhtryE1G6JBD96HRRF1TDKnKOvvRovb3dy5Ds2qQQkM2N7cSVAMkuQnEgtOiUd2Pq7ZeHDKtE1fIrPm5gKf07eL3VoX79ObJMQFBfEpSd0oGIPakx7QDJ6NS4TVgxXHLNwMyMTEV_nUYBgPyBTcArt5LMmYDllrD-t9YLOcCxMBbsgMtsRuBKneC-52Eg4WhkCpxfSxpvkPWNRec-0M5jCMwEHvEjLrrClthPUjJploHa2Lmy3sgx9Zi3oXQrCsFG2gxPm1wwgp7-tY-G6HRmn5IHjxknPe82Vx2VYfO3tB1UEwUvNARGYCNlPCsNfa1mPdNcnlqmpIwlm00
)
__task3__
![](
http://www.plantuml.com/plantuml/png/fLJDRXCn4BxdAQoUDeYy02rLHGzSg8G8vO8uJ7U7nCHhRsrl2QguWyGRy2fvfxm2ancFiwG73lJWdH_FzyqtzUGgPOXvxDsiTP2IkGuknCUPeJ_hiuddrLmTpJinsz0F4F5zQERivx3CqVfLSV5-19UAiuQqlWuTaij-1ByX-_kKzZPR9zGhp1pXOdRVWUz2pq65r4itC31InJ0BmPjHhnW_Gujc6IAPvb78NO2keUJ7JmOTzkXpcekaHFSQjXd_hGElRkrrIJLjBeYs7mg2SeW2GGSfbR6OWT3CItDsLhWKfpAchoI5AerzpdF-Gd5blHzjk_blKe7vD-TnSc-iXpk7XI7HJ4AosGRVg666OapcfdUEeG_WHcmcWcgv82kFaw_KLPoJhFQEkIIUNgWybD7k5Ow6f3qdGT8Ma4VXqA_okf0COpv5bqdPexX6VIMzWHpjrk0se--a1sb14eVxy_tkzoIqt_sWu7xtYy-VdBcu20yOe-tmyh8k5xEmgB1OL4dAIufENeZsBczVDiEqXtCY_Sd_yfnlArx3LNNjIlJLDzhA3MkFPCodYwrFIu6Rrs6CdG4VyXeBqWbSuYrM1LDnaw2kTctu6OMAHDrF3vigLvnqE5ckBapYZuGiWODliRGzHFi0kHGrnwScbSrV02NhhCVRuV1Ca6rzEX0Jyc_8P1c51BVOZXarGUg6WtfkbsKApQmyf8K8UM4w16SkPbVekx5tVm00
)
###补充说明
排序的依据是给定的图片中的顺序，从左上到右下,因此方阵排序完毕的结果就是给定的png图片
task3的Matrix继承Line并重写toString(),其他什么都没有改，就很方便地完成了要求的任务
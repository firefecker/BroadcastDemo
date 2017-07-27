## Broadcast

[Android广播知识讲解](http://www.jianshu.com/p/ca3d87a4cdf3)

此处对android的广播进行了相关测试

主要测试的有：普通广播、系统广播、有序广播、app应用内广播、检测网络的广播等。需要的可以download或者fork

<table>
  <tr>
    <th>注册方式</th>
    <th>特点</th>
    <th>应用场景</th>
  </tr>
  <tr>
<td>静态注册（常驻广播）</td>
<td>常驻，不受任何组件的生命周期影响\n(应用程序关闭后，如果有信息广播来，程序依旧会被系统调用)\n缺点：耗电、占内存</td>
<td>需要时刻监听广播</td>
  </tr>
</table>



### 特别注意
对于不同注册方式的广播接收器回调OnReceive（Context context，Intent intent）中的context返回值是不一样的：

对于静态注册（全局+应用内广播），回调onReceive(context, intent)中的context返回值是：ReceiverRestrictedContext；

对于全局广播的动态注册，回调onReceive(context, intent)中的context返回值是：Activity Context；

对于应用内广播的动态注册（LocalBroadcastManager方式），回调onReceive(context, intent)中的context返回值是：Application Context。

对于应用内广播的动态注册（非LocalBroadcastManager方式），回调onReceive(context, intent)中的context返回值是：Activity Context；

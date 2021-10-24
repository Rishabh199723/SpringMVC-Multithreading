iziToast.settings({
    timeout: 3000, // default timeout
    resetOnHover: true,
    // icon: '', // icon class
    transitionIn: 'flipInX',
    transitionOut: 'flipOutX',
    position: 'topRight', // bottomRight, bottomLeft, topRight, topLeft, topCenter, bottomCenter, center
});
let showNotifications = $("input[name='showNotification']").val();
if(showNotifications=="true" ) {
    iziToast.success({timeout: 2500, icon: 'fa fa-chrome', message: 'Todo Created Successfully'});
}
var ps = new PerfectScrollbar(".customScroll");
ps.update();
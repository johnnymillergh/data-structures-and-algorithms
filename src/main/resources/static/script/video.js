// noinspection JSUnusedGlobalSymbols
const vm = new Vue({
    el: '#app',
    data: {
        videoSource: ''
    },
    mounted() {
        const currentUrl = window.location.href;
        const split = currentUrl.split('/');
        this.videoSource = `${split[0]}//${split[2]}/${split[3]}/test-table/demo-video`;
    }
});

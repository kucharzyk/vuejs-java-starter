var webpackConf = require('./webpack.base.conf');
delete webpackConf.entry;

module.exports = function (config) {
  config.set({
    browsers: ['PhantomJS'],
    frameworks: ['jasmine'],
    reporters: ['spec'],
    files: ['../src/test/vuejs/unit/index.js'],
    preprocessors: {
      '../src/test/vuejs/unit/index.js': ['webpack']
    },
    webpack: webpackConf,
    webpackMiddleware: {
      noInfo: true
    }
  });
};

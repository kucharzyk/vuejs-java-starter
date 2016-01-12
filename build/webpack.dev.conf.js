var config = require('./webpack.base.conf');

config.devtool = 'eval-source-map';

// set output path for development
config.output.publicPath = 'http://localhost:3000/dist/';

config.devServer = {
  host: '0.0.0.0',
  port: 3000,
  historyApiFallback: true,
  noInfo: true,
  contentBase: 'src/main/resources/static/',
  proxy: {
    '/rest/*': 'http://localhost:8080'
  }
};

module.exports = config;

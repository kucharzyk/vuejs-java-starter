var config = require('./webpack.base.conf');

config.devtool = 'eval-source-map';

// Serve fonts and images as data-url
config.module.loaders.push(
  {
    test: /\.(png|jpg|gif|svg)$/,
    loader: 'url'
  },
  {
    test: /\.(woff|eot|ttf|woff2)$/i,
    loader: 'url'
  }
);

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

var webpack = require('webpack');
var path = require('path');

module.exports = {
  entry: {
    app: './src/main/vuejs/main.js'
  },
  output: {
    path: path.resolve(__dirname, '../src/main/resources/static/dist/'),
    filename: '[name].js'
  },
  resolve: {
    extensions: ['', '.js', '.vue'],
    alias: {
      'src': path.resolve(__dirname, '../src')
    }
  },
  module: {
    loaders: [
      {
        test: /\.vue$/,
        loader: 'vue'
      },
      {
        test: /\.js$/,
        loader: 'babel!eslint',
        exclude: /node_modules/
      },
      {
        test: /\.json$/,
        loader: 'json'
      },
      {
        test: /\.(png|jpg|gif|svg)/,
        loader: 'url',
        query: {
          limit: 10000,
          name: '[name].[ext]?[hash]'
        }
      },
      {
        test: /\.(woff|eot|ttf|woff(2)?|otf)/i,
        loader: 'file-loader?[name].[ext]?[hash]'
      }
    ]
  },
  vue: {
    loaders: {
      js: 'babel!eslint'
    },
    autoprefixer: {
      browsers: ['last 2 versions']
    }
  },
  eslint: {
    formatter: require('eslint-friendly-formatter')
  },
  plugins: [
    new webpack.ProvidePlugin({
      $: 'jquery',
      jQuery: 'jquery',
      'window.jQuery': 'jquery',
      'Tether': 'tether',
      'window.Tether': 'tether'
    })
  ]
};

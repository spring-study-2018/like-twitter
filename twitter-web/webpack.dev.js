const merge = require('webpack-merge');
const common = require('./webpack.common');

module.exports = merge(common, {
    mode: 'development',
    devtool: 'inline-source-map',
    devServer: {
        contentBase: './dist',
        publicPath: '/',
        historyApiFallback: true,
        port: 3000,
        proxy: {
            "/api": "http://localhost:8080"
        }
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                exclude: /node_modules/,
                use: [
                    'style-loader',
                    'css-loader?modules&localIdentName=[hash:base64:3]_[name]_[local]'
                ]
            }
        ]
    }
});

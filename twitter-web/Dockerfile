FROM node:8

# Make directory to hold app
RUN mkdir -p /prod/service/webroot
WORKDIR /prod/service/webroot

# Copy our dependencies first since they don't change often
COPY package.json package.json

#COPY package-lock.json package-lock.json
# Install npm modules referenced in package.json
RUN npm install

# Copy source
COPY client             client
COPY server             server
COPY static             static
COPY webpack.common.js  webpack.common.js
COPY webpack.prod.js    webpack.prod.js
COPY .babelrc           .babelrc

# bundling by webpack
RUN npm run build

EXPOSE 3000
CMD ["npm", "run", "www"]

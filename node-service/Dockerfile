FROM node:alpine
WORKDIR /usr/app
COPY package.json yarn.lock ./
RUN npm install
COPY . .
EXPOSE 5000
CMD [ "npm", "start" ]

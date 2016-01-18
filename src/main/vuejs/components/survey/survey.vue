<template>
  <div class="survey">
    <h1>{{survey.title}}</h1>
    <h3>page {{currentPageNumber}}/{{pageCount}}</h3>
    <label>numbered
      <input type="checkbox" v-model="survey.numbered"/>
    </label>
    <div>
      <button class="btn ptn-primary" @click="prevPage" :disabled="firstPage">prev page</button>
      <button class="btn ptn-primary" @click="nextPage" :disabled="lastPage">next page</button>
    </div>

    <ol v-if="survey.numbered" :start="counterStart(currentPage)">
      <li v-for="q in currentPage.questions">
        <question :q="q"></question>
      </li>
    </ol>
    <ul v-else="">
      <li v-for="q in currentPage.questions">
        <question :q="q"></question>
      </li>
    </ul>

    <div>
      <button class="btn ptn-primary" @click="prevPage" :disabled="firstPage">prev page</button>
      <button class="btn ptn-primary" @click="nextPage" :disabled="lastPage">next page</button>
    </div>

    <br><br>
    <pre>{{pagesAsJson}}</pre>

  </div>
</template>
<script>
  import Question from './question.vue';
  import surveyData from './data';

  export default{
    name: 'survey',
    data: function () {
      return {
        currentPageNumber: 1,
        survey: {}
      };
    },
    methods: {
      counterStart: function (page) {
        var counter = 1;
        var pageIndex = this.pages.indexOf(page);
        for (let i = 0; i < pageIndex; i++) {
          counter += this.pages[i].questions.length;
        }
        return counter;
      },
      prevPage: function () {
        this.currentPageNumber--;
        if (this.currentPageNumber <= 0) {
          this.currentPageNumber = 0;
        }
      },
      nextPage: function () {
        this.currentPageNumber++;
        if (this.currentPageNumber > this.pageCount) {
          this.currentPageNumber = this.pageCount;
        }
      }
    },

    computed: {
      pages: function () {
        let currentPageNumber = 1;
        let pageQuestions = [];
        let pages = [{page: currentPageNumber, questions: pageQuestions}];

        if (this.survey.questions) {
          this.survey.questions.forEach(function (question) {
            if (question.type !== 'BREAK_PAGE') {
              pageQuestions.push(question);
            } else {
              currentPageNumber++;
              pageQuestions = [];
              pages.push({page: currentPageNumber, questions: pageQuestions});
            }

          });
        }

        return pages;
      },
      pageCount: function () {
        return this.pages.length;
      },
      firstPage: function () {
        return this.currentPageNumber === 1;
      },
      lastPage: function () {
        return this.currentPageNumber === this.pageCount;
      },
      currentPage: function () {
        if (this.pages && this.pages[this.currentPageNumber - 1]) {
          return this.pages[this.currentPageNumber - 1];
        } else {
          return {
            questions: []
          };
        }
      },
      pagesAsJson: function () {
        return JSON.stringify(this.pages, null, 2);
      }
    },

    ready: function () {
      console.log('loading survey');
      this.survey = surveyData;
    },

    components: {
      Question
    }

  };
</script>

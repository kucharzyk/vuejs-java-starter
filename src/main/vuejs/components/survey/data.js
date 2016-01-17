var survey = {
  title: 'Simple survey',
  numbered: true,
  questions: [
    {
      id: 1,
      name: 'What\'s answer #1?',
      type: 'TEXT',
      answer: null
    },
    {
      id: 2,
      name: 'What\'s answer #2?',
      type: 'COMBO',
      options: [
        {
          name: 'Option A',
          value: 'A'
        },
        {
          name: 'Option B',
          value: 'B'
        },
        {
          name: 'Option C',
          value: 'C'
        }
      ],
      answer: null
    },
    {
      id: 3,
      type: 'BREAK_PAGE',
      answer: null
    },
    {
      id: 4,
      name: 'What\'s answer #4?',
      type: 'RADIO',
      options: [
        {
          name: 'Option A',
          value: 'A'
        },
        {
          name: 'Option B',
          value: 'B'
        },
        {
          name: 'Option C',
          value: 'C'
        }
      ],
      answer: null
    },
    {
      id: 5,
      name: 'What\'s answer #5?',
      type: 'NONE',
      answer: null
    },
    {
      id: 6,
      name: 'What\'s answer #6?',
      type: 'COMBO',
      options: [
        {
          name: 'Option A',
          value: 'A'
        },
        {
          name: 'Option B',
          value: 'B'
        },
        {
          name: 'Option C',
          value: 'C'
        }
      ],
      answer: null
    },
    {
      id: 7,
      type: 'BREAK_PAGE',
      answer: null
    },
    {
      id: 8,
      name: 'What\'s answer #8?',
      type: 'RADIO',
      options: [
        {
          name: 'Option A',
          value: 'A'
        },
        {
          name: 'Option B',
          value: 'B'
        },
        {
          name: 'Option C',
          value: 'C'
        }
      ],
      answer: null
    }
  ]
};

export default survey;

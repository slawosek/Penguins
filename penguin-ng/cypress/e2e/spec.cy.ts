describe('Root page check', () => {
  it('Visits the initial project page with basic navigation', () => {
    cy.visit('/')
    cy.get('[data-cy="homeNavigation"]').should('be.visible');
    cy.get('[data-cy="tableNavigation"]').should('be.visible');
  })
})
